
// THE NUMBERS SHOULD BE SORTED
#include <iostream>
using namespace std;

void b_search(int n, int a[]);

int main()
{
  int n, a[100];

  cout << "Enter the number of terms to be inserted: ";
  cin >> n;

  cout << "Enter the numbers: \n";
  for(int i=0; i<n; i++)
  {
    cin >> a[i];
  }

  b_search(n, a);

  return 0;
}

void b_search(int n, int a[])
{
  int beg, end, middle, s;

  cout << "Enter the number to be searched: ";
  cin >> s;

  beg = 0;
  end = n - 1;
  middle = (beg + end)/2;

  while(beg <= end)
  {
    if(a[middle] < s)
    {
      beg = middle + 1;
    }
    else if(a[middle] == s)
    {
      cout << "FOUND " << s << " AT POSITION " << middle + 1 << endl;
      break;
    }
    else
    {
      end = middle - 1;
    }
    middle = (beg + end)/2;
  }
  if(beg > end)
  {
    cout << "NOT FOUND " << s << " AT ANY POSITION" << endl;
  }
}
